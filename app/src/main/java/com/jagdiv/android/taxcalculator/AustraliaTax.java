package com.jagdiv.android.taxcalculator;

/**
 * Created by Dell on 7/05/2016.
 */
//class TestEnum{
//  static enum Wealth {
class AustraliaTax {

    public enum ResidentType {
        NonResident, Resident, children;
    }

    public enum Wealth {

        VERYPOOR(18200), MIDPOOR(37000), POOR(80000), RICH(180000), VERYRICH(180001);

        private int money;

        private Wealth(int money) {
            this.money = money;
        }

        private int getMoney() {
            return money;
        }//for getting enumType money

        private void setMoney(int money) {//here change value of enumtype
            this.money = money;
        }

        public static float getWealth(int money, String ResidenType) {
            Wealth found = VERYRICH;
            for (Wealth w : values()) {
                if (money <= w.money) {
                    found = w;
                    if (ResidenType.equals(ResidentType.NonResident.toString())) {
                        if (found.toString() == "MIDPOOR" || found.toString() == "VERYPOOR")//beause nonrsident dont have less than poor
                            found = Wealth.POOR;
                    }
                    break;
                }
            }
            float taxToPay = 0;

            if (ResidenType.equals(ResidentType.NonResident.toString()))
                taxToPay = found.calculateTaxNonResident(found, money);
            else if (ResidenType.equals(ResidentType.Resident.toString()))
                taxToPay = found.calculateTaxResident(found.toString(), money);

            System.out.print("money " + money + " status" + found + " taxToPay " + taxToPay);
            return taxToPay;
        }

        private float calculateTaxNonResident(Wealth found, int money) {
            float taxToPay = 0;
            float centsPerDollar = 0;
            float minimumAmount = 0;
            int calculatedMoney = money;
            switch (found) {
                case POOR:
                    centsPerDollar = 0.325f;
                    break;
                case RICH:
                    centsPerDollar = 0.37f;
                    minimumAmount = 26000;
                    calculatedMoney = money - Wealth.POOR.getMoney();
                    break;
                case VERYRICH:
                    centsPerDollar = 0.45f;
                    minimumAmount = 63000;
                    calculatedMoney = money - Wealth.RICH.getMoney();
                    break;
            }
            // return minimumAmount+(centsPerDollar*money);
            return calculateAmount(centsPerDollar, minimumAmount, calculatedMoney);
        }

        private float calculateTaxResident(String found, int money) {
            float taxToPay = 0;
            float centsPerDollar = 0;
            float minimumAmount = 0;
            int calculatedMoney = money;

            if (found == "VERYPOOR") {//nothing to pay
            }
            if (found == "MIDPOOR") {
                centsPerDollar = 0.19f;
            } else if (found == "POOR") {
                centsPerDollar = 0.325f;
                minimumAmount = 3572;
                calculatedMoney = money - Wealth.MIDPOOR.getMoney();
            } else if (found == "RICH") {
                centsPerDollar = 0.37f;
                minimumAmount = 17547;
                calculatedMoney = money - Wealth.POOR.getMoney();
            } else if (found == "VERYRICH") {
                centsPerDollar = 0.45f;
                minimumAmount = 54547;
                calculatedMoney = money - Wealth.RICH.getMoney();
            }

            // return minimumAmount+(centsPerDollar*money);
            return calculateAmount(centsPerDollar, minimumAmount, calculatedMoney);
        }

        private float calculateAmount(float centsPerDollar, float minimumAmount, int money) {
            System.out.print(" centsPerDollar " + centsPerDollar + "money " + money + " ");

            float taxToPay = minimumAmount + (centsPerDollar * money);
            return taxToPay;
        }
    }
}//class

 /*   public static void main(String[] args) {

        System.out.println(Wealth.getWealth(0));
        System.out.println(Wealth.getWealth(70000));
        System.out.println(Wealth.getWealth(80000));
        System.out.println(Wealth.getWealth(80001));
        System.out.println(Wealth.getWealth(179999));
        System.out.println(Wealth.getWealth(180000));
        System.out.println(Wealth.getWealth(180001));
        System.out.println(Wealth.getWealth(180003));

    }
}
 private static void usingEnumSet() {
        EnumSet<Wealth> enumSet = EnumSet.allOf(Wealth.class);
        for(Wealth tsenum : enumSet){
            System.out.println("Using EnumSet, money = "+tsenum.getMoney());
        }
    }

    private static void usingEnumMap() {
        EnumMap<Wealth, String> enumMap = new EnumMap<Wealth,String>(ThreadStates.class);
        enumMap.put(Wealth.POOR, "This POOR");
        enumMap.put(Wealth.RICH, "ThIs RICH");
        enumMap.put(Wealth.VERYRICH, "ThIS VERYRICH");

        Set<Wealth> keySet = enumMap.keySet();
        for(Wealth key : keySet){
            System.out.println("key="+key.toString()+":: value="+enumMap.get(key));
        }

    }
    //Enum can override functions
    @Override
    public String toString(){
        return "Default Constructors implementation. money="+getMoney();
    }
*/