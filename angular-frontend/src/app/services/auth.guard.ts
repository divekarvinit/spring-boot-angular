import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { GlobalConstant } from "../global-constants";
import { Router } from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private global : GlobalConstant, private router : Router){

  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
      if(!this.global.isAuthenticated){
        this.router.navigate(['/']);
      }     
      return this.global.isAuthenticated;
  }
}
