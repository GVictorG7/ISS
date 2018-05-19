import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MenuComponent} from "./menu/menu.component";
import {MatToolbarModule} from '@angular/material/toolbar';
import {
  MatIconModule,
  MatListModule,
  MatMenuModule,
  MatSidenav,
  MatSidenavContainer,
  MatSidenavModule
} from "@angular/material";

@NgModule({
  imports: [
    CommonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatMenuModule,
    MatIconModule


  ],
  declarations: [
    MenuComponent
  ],
  exports: [
    MenuComponent
  ]
})
export class SharedModule {
}
