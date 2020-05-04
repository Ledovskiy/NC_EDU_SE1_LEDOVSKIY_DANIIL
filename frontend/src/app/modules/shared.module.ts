import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatSliderModule} from '@angular/material/slider';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {QuillModule} from 'ngx-quill';


@NgModule({
  imports: [
    ReactiveFormsModule,
    FormsModule,
    MatInputModule,
    MatToolbarModule,
    MatSliderModule,
    MatIconModule,
    QuillModule.forRoot()
  ],
  exports: [
    ReactiveFormsModule,
    FormsModule,
    MatInputModule,
    MatToolbarModule,
    MatSliderModule,
    MatIconModule,
    QuillModule
  ]

})

export class SharedModule {
}
