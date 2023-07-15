package com.example.miniproj2;

public class Laws {
        int cnr;
        String casetype;
        String district;
        String advocate;
        String typeofcourt;
        String act;
        String partyname;
        String year;
        String date;
        String courtname;
        String casestatus;
        String regdate;
        String section;

        public Laws(String partyname, String casestatus, String courttype){   }

        public Laws(int cnr, String casetype,String advocate,String district,String typeofcourt,String act,String partyname, String casestatus, String courtname, String date, String year, String regdate, String section){
            this.cnr = cnr;
            this.casetype = casetype;
            this.advocate=advocate;
            this.district=district;
            this.typeofcourt=typeofcourt;
            this.act=act;
            this.partyname=partyname;
            this.year=year;
            this.date=date;
            this.courtname=courtname;
            this.regdate=regdate;
            this.section=section;
            this.casestatus=casestatus;
        }

        public Laws(String casetype,String advocate,String district,String typeofcourt,String act,String partyname, String casestatus, String courtname, String date, String year, String regdate, String section){
            this.casetype = casetype;
            this.advocate=advocate;
            this.district=district;
            this.typeofcourt=typeofcourt;
            this.act=act;
            this.partyname=partyname;
            this.year=year;
            this.date=date;
            this.courtname=courtname;
            this.regdate=regdate;
            this.section=section;
            this.casestatus=casestatus;
        }

        public int getCnr(){
            return this.cnr;
        }
        public void setCnr(int cnr){
            this.cnr = cnr;
        }

        public String getCasetype(){
            return this.casetype;
        }
        public void setCasetype(String casetype){
            this.casetype = casetype;
        }

        public String getAdvocate(){
            return this.advocate;
        }
        public void setAdvocate(String advocate){
            this.advocate = advocate;
        }

        public String getTypeofcourt(){
            return this.typeofcourt;
        }
        public void setTypeofcourt(String typeofcourt){
            this.typeofcourt= typeofcourt;
        }

        public String getAct(){
            return this.act;
        }
        public void setAct(){
            this.act = act;
        }

        public String getPartyname()
        {
            return this.partyname;
        }
        public void setPartyname(){
            this.partyname = partyname;
        }

        public String getDistrict(){
            return this.district;
        }
        public void setDistrict(){
            this.district = district;
        }

        public String getYear(){
        return this.year;
    }
        public void setYear(){
        this.year = year;
    }

        public String getDate(){
        return this.date;
    }
        public void setDate(){
        this.date = date;
    }

        public String getCourtname(){
        return this.courtname;
    }
        public void setCourtname(){
        this.courtname = courtname;
    }

        public String getCaseStatus(){
        return this.casestatus;
    }
        public void setCaseStatus(){
        this.casestatus = casestatus;
    }

        public String getSection(){
        return this.section;
    }
        public void setSection(){
        this.casestatus = section;
    }

        public String getRegdate(){
        return this.casestatus;
    }
        public void setCRegdate(){ this.regdate = regdate; }


}
