package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		/* FILL CODE */
        if(type < 0 || type > 2){
            this.type = 1;
            setPriceperstation(30);
        }else{
            this.type = type;
            if(type == 2){
                setPriceperstation(25);
            }else{
                setPriceperstation(30);
            }
        }

	}
	
	public void setStation(Station start,Station end) {
		/* FILL CODE */
        setStart(start);
        setEnd(end);
	}
	
	public double calculatePrice() {
		/* FILL CODE */
        if(!isStationValid(start,end)) return -1;
        int distance = getStationDistance(start,end);
        switch (type){

            case 0:
                if(distance <= 4){
                    return getPricePerStation()*distance;
                }else {
                    return getPricePerStation()*distance*80/100;
                }
            case 1:
                return getPricePerStation()*distance;
            case 2:
                return getPricePerStation()*distance*60/100;
            default:
                return  -1;
        }

	}

    public void setPriceperstation(int priceperstation) {
        this.priceperstation = priceperstation;
    }

    public void setStart(Station start) {
        this.start = start;
    }

    public void setEnd(Station end) {
        this.end = end;
    }

    public String getDescription() {
		String typename;
		
		switch(type) {
		
		case 0:
			typename = "Student";
			break;
		case 1:
			//FILL CODE
            typename = "Adult";
            break;
		case 2:
			//FILL CODE
            typename = "Elderly";
            if (getStationDistance(start,end)>6) typename = "Invalid";
            break;
		default:
			typename = "Invalid";
		}
		
		return typename+" Ticket, from "+this.getStart().getName()+" to "+this.getEnd().getName();
	}
	
	public boolean isStationValid(Station start,Station end) {
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
