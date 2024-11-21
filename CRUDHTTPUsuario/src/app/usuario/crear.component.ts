import { Component, OnInit } from '@angular/core';

import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { Product } from '../modelo/product';
import { ProductService } from '../servicios/product.service';



@Component({
  selector: 'app-crear',
  templateUrl: './crear.component.html',
  styleUrls: ['./crear.component.css']
})
export class CrearComponent implements OnInit {


  codigo!: number;
  nombre!: string;
  descripcion!: string;
  precio!: number;
  stock!: number;
  
  constructor(
    private productService :ProductService,
    private toast: ToastrService,
    private router: Router,

  ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
   const product = new Product(this.codigo,this.nombre,this.descripcion,this.precio,this.stock); 
   console.log(product);
   this.productService.crear(product).subscribe(
    data =>{
    this.toast.success(data.message,"OK",{timeOut: 3000,positionClass:'toast-top-center'});
    this.router.navigate(['']);
    },
    error=>{
      this.toast.error(error.error.message,"Error",{timeOut: 3000,positionClass:'toast-top-center'});

    }

   );
    



  }

}
