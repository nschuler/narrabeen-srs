import { NgModule } from '@angular/core';
import {
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule,
  MatInputModule,
  MatCheckboxModule,
  MatListModule,
  MatSnackBarModule,
  MatChipsModule,
  MatSelectModule,
  MatTooltipModule,
  MatSlideToggleModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatTableModule
} from '@angular/material';

const materialModules: any[] = [
  MatCardModule,
  MatButtonModule,
  MatFormFieldModule,
  MatCheckboxModule,
  MatInputModule,
  MatListModule,
  MatSnackBarModule,
  MatChipsModule,
  MatSelectModule,
  MatTooltipModule,
  MatSlideToggleModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatTableModule
];

@NgModule({
  imports: materialModules,
  exports: materialModules
})
export class MaterialComponentsModule { }
