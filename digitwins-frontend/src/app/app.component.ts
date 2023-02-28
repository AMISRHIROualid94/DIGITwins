import {Component, OnDestroy, OnInit} from '@angular/core';
import {EmployerModel} from "./models/employer.model";
import {EmployerService} from "./services/employer.service";
import {OAuthService} from "angular-oauth2-oidc";
import {authconfig} from "./authConfig/auth.config";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit,OnDestroy{

  employers:EmployerModel[]

  subscription:Subscription

  constructor(private oauthservice:OAuthService, private employerService:EmployerService) {
    this.configure()
  }

  ngOnInit(): void {

  }

  configure(){
    this.oauthservice.configure(authconfig)
    this.oauthservice.loadDiscoveryDocumentAndTryLogin()
  }

  getAllEmployers(){
    this.subscription = this.employerService.getEmployers().subscribe(employers =>{
      this.employers = employers
      console.log(this.employers)
    })

  }

  login(){
    this.oauthservice.initCodeFlow()
  }

  logout(){
    this.oauthservice.logOut()
  }

  ngOnDestroy(): void {
  this.subscription.unsubscribe();
  }



}
