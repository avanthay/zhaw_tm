

public class Machine {

	private Band band1 = new Band("band1");
	private Band band2 = new Band("band2");
	private Band band3 = new Band("band3");
	private Config currentconfig = null;
	private int step = 0;
	private int currentstate = 0;
	private boolean finish = false;

	public String getActualString(Band band) {
		return band.getString(band.getPosition() + band.getReference());
	}

	public void setActualString(Band band, String x) {
		band.setString(band.getPosition() + band.getReference(), x);
	}

	public void moveBand(Band band, String move) {
		if (move.equals("R")) {
			band.setPosition(band.getPosition() + 1);
		}
		if (move.equals("L")) {
			band.setPosition(band.getPosition() - 1);
		}
		if (band.getPosition() < (-1 * band.getReference())) {
			band.addString(0, " ");
			band.setReference(band.getReference() + 1);
		}
		if ((band.getPosition() + band.getReference()) > (band.getLength() - 1)) {
			band.addString(band.getLength(), " ");
		}
		if (move.equals("S")) {
			return;
		}
	}

	public void setConfig(String string) {
		if (string.equals("Multiplication")) {
			currentconfig = new Multiplication();
		}
		if (string.equals("Faculty")) {
			currentconfig = new Faculty();
		}
	}

	public void setInput(String input, Band band) {
		String[] derString = input.split("");
		for (int i = 1; i < derString.length; i++) {
			band.setString(i - 1, derString[i]);
		}
	}

	public void step() {
		if (finish == true
				|| currentconfig.getString(currentstate).equals("final")) {
			finish = true;
			return;
		} else {
			step++;
			String x = currentconfig.getString(currentstate);
			String[] datSatz = x.split("/");
			for (int i = 0; i < datSatz.length; i++) {
				String[] kurzDatSatz = datSatz[i].split(",");
				String[] read = kurzDatSatz[0].split("");
				String[] write = kurzDatSatz[1].split("");
				String[] move = kurzDatSatz[2].split("");
				String newState = kurzDatSatz[3];
				if (getActualString(band1).equals(read[1])
						&& getActualString(band2).equals(read[2])
						&& getActualString(band3).equals(read[3])) {
					setActualString(band1, write[1]);
					setActualString(band2, write[2]);
					setActualString(band3, write[3]);
					moveBand(band1, move[1]);
					moveBand(band2, move[2]);
					moveBand(band3, move[3]);
					this.currentstate = Integer.parseInt(newState);
					return;
				}
			}
		}
	}

	public int getResult() {
		int result = 0;
		for (int i = 0; i < band3.getLength(); i++) {
			if (band3.getString(i).equals("1")) {
				result++;
			}
		}
		return result;
	}

	public void reset() {
		band1.resetBand();
		band2.resetBand();
		band3.resetBand();
		this.step = 0;
		this.currentstate = 0;
		this.finish = false;
	}

	public Band getBand1() {
		return band1;
	}

	public Band getBand2() {
		return band2;
	}

	public Band getBand3() {
		return band3;
	}

	public int getStep() {
		return this.step;
	}

	public boolean getFinisched() {
		return this.finish;
	}

	public Config getCurrentconfig() {
		return this.currentconfig;
	}
	
	public int getCurrentState(){
		return this.currentstate;
	}
}
