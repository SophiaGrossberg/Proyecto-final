import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../modelo/product';
import { ProductService } from '../servicios/product.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent implements OnInit {

  product: Product |undefined;

  constructor(
      private productService:ProductService,
      private activateRoute:ActivatedRoute,
      private router:Router,
      private toast:ToastrService,
      private httpClient:HttpClient
    ) {}
  
    ngOnInit(): void {
      const codigo=this.activateRoute.snapshot.params['codigo'];
      console.log('codigo recibido',codigo);
      this.getProducto(codigo);
    }
  
  getProducto(codigo:number):void{
    this.productService.detalle(codigo).subscribe(
      data=>{
        console.log('Producto Recibido');
        this.product=data;
       },
      error =>{
        this.toast.error('Error al cargar el producto',error);
      }
      );
  }

}
