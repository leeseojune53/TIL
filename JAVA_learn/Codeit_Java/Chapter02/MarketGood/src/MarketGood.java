public class MarketGood {
    private String name;
    private int retailPrice;
    private int discountRate;

    public MarketGood(String name, int retailPrice, int discountRate){
        if(0<=discountRate&&discountRate<=100){
            this.discountRate = discountRate;
        }else this.discountRate = 0;
        this.name = name;
        this.retailPrice = retailPrice;
    }

    public MarketGood(String name, int retailPrice){
        this.name = name;
        this.retailPrice = retailPrice;
        discountRate = 0;
    }

    public String getName(){
        return name;
    }

    public int getRetailPrice(){
        return retailPrice;
    }

    public void setDiscountRate(int discountRate){
        this.discountRate = discountRate;
    }

    public int getDiscountRate(){
        return discountRate;
    }

    public int getDiscountedPrice(){
        return retailPrice - (retailPrice*discountRate/100);
    }
}
