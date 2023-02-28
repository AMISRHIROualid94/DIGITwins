export class EmployerModel{

  public numCnss:String
  public fonction:String
  public dateEmbauche:Date
  public dateSortie:Date
  public nbreCP:Number
  public nbrRC:Number
  public nbrRH:Number

public EmployerModel(){

}

  constructor(numCnss:String,fonction:string,dateEmbauche:Date,dateSortie:Date,
              nbreCP:number,nbrRC:number,nbrRH:number) {
    this.numCnss = numCnss
    this.fonction = fonction
    this.dateEmbauche = dateEmbauche
    this.dateSortie = dateSortie
    this.nbreCP = nbreCP
    this.nbrRC = nbrRC
    this.nbrRH = nbrRH
  }
}
