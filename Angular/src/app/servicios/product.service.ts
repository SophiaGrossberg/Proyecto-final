import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Product} from '../modelo/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  usuarioURL = environment.apiRestURL + '/products';


  constructor(private httpClient: HttpClient) { }



  public list(): Observable<Product[]> {

    return this.httpClient.get<Product[]>(this.usuarioURL);

  }
  public detalle(codigo: number): Observable<Product> {

    return this.httpClient.get<Product>(this.usuarioURL + `/${codigo}`);


  }
  public crear(product: Product): Observable<any> {

    return this.httpClient.post<any>(this.usuarioURL, product)

  }

  public update(product:any):Observable<any>{
    return this.httpClient.put(this.usuarioURL +`/${product.codigo}`,product);
  }


public eliminar(codigo:number){
  this.usuarioURL=this.usuarioURL + `/${codigo}`
  return this.httpClient.delete<any>(this.usuarioURL);
  
}

}
