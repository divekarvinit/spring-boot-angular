import { Injectable } from '@angular/core';

@Injectable()
export class GlobalConstant {
    baseUrl: string = "http://localhost:8080";
    isAuthenticated: boolean = false;
}