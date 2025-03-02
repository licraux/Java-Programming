public class RejseKort{

    private int wallet;
    private boolean cardstate;
    private int time;
    private int isCheckInTime;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    

    public RejseKort(){

        this.wallet = 100;
        this.time = 0;
        this.cardstate = false;
        this.isCheckInTime = 0;
        this.maxX = 0;
        this.maxY = 0;
        this.minX = 0;
        this.minY = 0;

    }



    public void depositMoney(int dkk){
        if (dkk < 0){
            System.out.println("Error: Cannot deposit negative amount");
        }
        else{
            wallet += dkk;
            System.out.println(dkk + " DKK deposited. New balance: " + wallet + " DKK");
        }
    }

    public boolean isCheckedIn(int timeStamp){
        isCheckInTime = timeStamp;
        int calcTimePassed = timeStamp - time;
        if (timeStamp > time && timeStamp <= 120){
            System.out.println(calcTimePassed + " minutes has passed since last check in");
            cardstate = true;
            return cardstate;
        }
        System.out.println("Card is checked out");
        cardstate = false;
        return cardstate;

    }

    public void checkIn(int x, int y, int timeStamp){
        this.time = timeStamp;
        this.minX = x;
        this.minY = y;
        if (wallet < 100){
            int addMoney = 0;
            addMoney = 100 - wallet;
            System.out.println("Not enough money in account to check in. Please deposit at least " + addMoney +" DKK");
        }
        else{
            if (cardstate == false){
                System.out.println("Checked in");
                cardstate = true;
            }
            else{
                int differenceTime = isCheckInTime - time;
                System.out.println("Continued journey (" + differenceTime + "minutes since last check in)");
            }
        }


    }

    public void checkOut(int x, int y, int timeStamp){
        this.maxX = x;
        this.maxY = y;
        int priceTicket = 0;
        int formula = 12 + (maxX - minX + maxY - minY) * 3;
        priceTicket = formula;
        if (priceTicket < 12 && cardstate == true){
            priceTicket = 12;
            wallet = wallet - priceTicket;
            cardstate = false;
            int differenceTime = isCheckInTime - time;
            System.out.println("Checked out! " + differenceTime + "minutes since last check in. Price is " + priceTicket + " DKK, remaining balance is " + wallet + " DKK");
        }
        else if (priceTicket > 50 && cardstate == true){
            priceTicket = 50;
            wallet = wallet - priceTicket;
            cardstate = false;
            int differenceTime = isCheckInTime - time;
            System.out.println("Checked out! " + differenceTime + "minutes since last check in. Price is " + priceTicket + " DKK, remaining balance is " + wallet + " DKK");

        }
        else if ((12 <= priceTicket || priceTicket <= 50) && cardstate == true){
            wallet = wallet - priceTicket;
            cardstate = false;
            int differenceTime = isCheckInTime - time;
            System.out.println("Checked out! " + differenceTime + "minutes since last check in. Price is " + priceTicket + " DKK, remaining balance is " + wallet + " DKK");

        }
        else{
            System.out.println("Error: Cannot check out; Not currently checked in");
        }

    }


}

