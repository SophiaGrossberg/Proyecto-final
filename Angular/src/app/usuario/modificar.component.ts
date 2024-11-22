import { Component, OnInit } from '@angular/core';
import { Product } from '../modelo/product';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProductService } from '../servicios/product.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-modificar',
  templateUrl: './modificar.component.html',
  styleUrls: ['./modificar.component.css']
})
export class ModificarComponent implements OnInit {
  product:Product =new Product(0,'','',0,0);
  constructor(
    private productService:ProductService,
    private activateRoute:ActivatedRoute,
    private router:Router,
    private toastr:ToastrService,
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
        this.toastr.error('Error al cargar el producto',error);
      }
      );
  }

  putProducto(product:any){
    this.productService.update(product).subscribe(
      data=>{
        console.log('Exitoso')
        this.product=data;
        this.router.navigate(['']);
      }
      
    )
    
  }

  
}
