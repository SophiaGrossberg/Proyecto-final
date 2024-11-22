export class Product {


   codigo: number;
    nombre:string;
    descripcion:string;
    precio: number;
    stock: number;
  

    constructor(codigo:number, nombre:string,descripcion:string,precio: number,stock: number){

        this.codigo= codigo;
        this.nombre= nombre;
        this.descripcion= descripcion;
        this.precio= precio;
        this.stock= stock
    }

}
