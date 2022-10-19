
import { FoodModel } from 'src/app/shared/models/Food';
import { Component, Injectable, OnInit } from '@angular/core';
import {FormBuilder,FormGroup} from '@angular/forms';
import { ApiService } from './api.service';
import { CartService } from 'src/app/services/cart.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  searchTerm:any;
  foodmodelobj: FoodModel = new FoodModel();

  foodData!: any;

  showAdd!: boolean;
  showUpdate!: boolean;
  formValue!: FormGroup;
 
  constructor(private router:Router, private activatedRoute: ActivatedRoute,private formbuilder: FormBuilder,private api: ApiService,
    private cartService: CartService) {}

  ngOnInit(): void {
    this.formValue = this.formbuilder.group({
      category :[''],
      cuisinename: [''],
      description: [''],
      foodname: [''],
      offers:[''],
      price: [''],
      status: [''],

    });
   
    this.getAllFood();

  }
  getAllFood() {
    this.api.getFood().subscribe((res: any) => {
      this.foodData = res;
      
      
      this.foodData.forEach((a:any)=>{
        Object.assign(a,{quantity:1,total:a.price});
      });
    })
  }
 
  search(){
    if(this.searchTerm==""){
      this.getAllFood();
    }else{
      this.foodData=this.foodData.filter((res: { searchTerm: { toLocalLowerCase: () => string; }; })=>{
        return res.searchTerm.toLocalLowerCase().match(this.searchTerm.toLocalLowerCase());
      })
    }
  }
  addtoCart(row: any){
    this.cartService.addtoCart(row);
  }
  row(row: any) {
    throw new Error('Method not implemented.');
  }
  food(food: any) {
    throw new Error('Method not implemented.');
  }
}
