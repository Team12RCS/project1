   package input;

    public class Car implements Comparable<Car>{
        private String plate;
        private String expDate;

        //Constructor
        public Car(String pl,String exd){
            this.plate = pl;
            this.expDate = exd;
        }

        public String getPlate() { return plate; }

        public void setPlate(String plate) { this.plate = plate; }

        public String getExpDate() { return expDate; }

        public void setExpDate(String expDate) { this.expDate = expDate; }


        @Override
        public int compareTo(Car o) {
            String str1 = this.getPlate();
            String str2 = o.getPlate();
            char a;
            char b;
            int aUni;
            int bUni;
            for(int i=0;i<str1.length();i++){
                a = str1.charAt(i);
                b = str2.charAt(i);
                aUni=(int) a;
                bUni=(int) b;
                if(aUni<bUni) return -1;
                else if(aUni>bUni) return 1;
            }

            return 0;
        }

    }
