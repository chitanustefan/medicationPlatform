import {MatButtonModule, MatToolbarModule, MatCheckboxModule,
    MatFormFieldModule, MatInputModule, MatIconModule,
    MatTableModule, MatPaginatorModule, MatDialogModule,
    MatGridListModule, MatSnackBarModule,MatSidenavModule,MatListModule,
    MatDatepickerModule, MatNativeDateModule, MatRadioModule,MatSelectModule} from '@angular/material';
import { AngularDualListBoxModule } from 'angular-dual-listbox';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import 'hammerjs';

@NgModule({
imports: [MatButtonModule,
MatCheckboxModule,
MatToolbarModule,
MatFormFieldModule,
MatInputModule,
MatSidenavModule,
MatListModule,
FormsModule,
ReactiveFormsModule,
MatIconModule,
MatTableModule,
MatPaginatorModule,
MatDialogModule,
MatGridListModule,
MatSnackBarModule ],
exports: [MatButtonModule,
MatCheckboxModule,
MatToolbarModule,
MatFormFieldModule,
MatSidenavModule,
MatListModule,
MatInputModule,
FormsModule,
ReactiveFormsModule,
MatIconModule,
MatTableModule,
MatPaginatorModule,
MatDialogModule,
MatGridListModule,
MatSnackBarModule,
MatDatepickerModule,
MatNativeDateModule,
MatRadioModule,
MatSelectModule,
AngularDualListBoxModule,
],
})

export class MaterialModule { }