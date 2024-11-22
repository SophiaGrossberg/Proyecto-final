import { Component, OnInit } from '@angular/core';

import { ToastrService } from 'ngx-toastr';
import { Product } from '../modelo/product';
import { ProductService } from '../servicios/product.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {



product : Product[]= [];
  

  constructor(
    private productService :ProductService,
    private toast : ToastrService, 
    private activatedRoute : ActivatedRoute,
    http:HttpClient,
    private toastr:ToastrService,
  ) { }

  ngOnInit(): void {
    this.getUsuarios();
  }

  getUsuarios():void{
this.productService.list().subscribe(
data =>{
 this.product = data;
console.log(this.product);
  

},
err =>{

}



);



  }
  onDelete(codigo:number){
   this.productService.eliminar(codigo).subscribe({
    next:(data)=>{
      console.log(data);
      this.toastr.success('1 registro eliminado');
    },
    error:(e)=>{
      console.log(e)
    }
   })
    
    }
}
