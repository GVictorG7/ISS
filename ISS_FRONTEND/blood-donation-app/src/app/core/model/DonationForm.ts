export class Adress {
  adress:string;
  city:string;
  county:string;
}

export class DonationForm{
  firstName:string;
  lastName:string;
  birthday:string;
  adress:Adress=new Adress();
  localAdress:Adress=new Adress();
  email:string;
  phone:string;
}
