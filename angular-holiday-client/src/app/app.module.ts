import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule }    from '@angular/common/http';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';

//angular material module
import {MatButtonModule, MatCheckboxModule, MatFormFieldModule} from '@angular/material';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatMenuModule} from '@angular/material/menu';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatListModule} from '@angular/material/list';
import {MatDialogModule} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatSelectModule} from '@angular/material/select';
import {MatSortModule} from '@angular/material/sort';

import { AppComponent } from './app.component';

import { StatesComponent } from './states/states.component';
import { EditHolidaysComponent,DeleteDialog,UpdateDialog} from './holidays/edit-holidays/edit-holidays.component';
import { ShowHolidaysComponent } from './holidays/show-holidays/show-holidays.component';

import {
  HolidaysLocalesDetailsComponent, HolidaysLocalesDetailsAddDialog,
  HolidaysLocalesDetailsUpdateDialog,HolidaysLocalesDetailsAdvSearchDialog
} from './holidays-locales-details/holidays-locales-details.component';

import { AdvancedSearchDialogComponent } from './advanced-search-dialog/advanced-search-dialog.component';
import { CountryComponent } from './country/country.component';
import { ConcernsQuestionsComponent } from './concerns-questions/concerns-questions.component';
import {
  CommonDeleteDialog, CommonAddDialog, CommonUpdateDialog,
  CommonAdvSearchDialog, CommonErrorDialog
} from './common-dialog/common-component';
import { CitiesComponent } from './cities/cities.component';
import { HolidayNotesComponent } from './holiday-notes/holiday-notes.component';
import { CommonComponent } from './common/common.component';
import { FormulaNotesComponent } from './formula-notes/formula-notes.component';
import { GregorianMonthdayMoonphaseComponent } from './gregorian-monthday-moonphase/gregorian-monthday-moonphase.component';
import { GregorianMonthdayComponent } from './gregorian-monthday/gregorian-monthday.component';
import { GregorianKdayafteretcMonthdayComponent } from './gregorian-kdayafteretc-monthday/gregorian-kdayafteretc-monthday.component';
import { GregorianMonthdaySpecialComponent } from './gregorian-monthday-special/gregorian-monthday-special.component';
import { GregorianNthkdayofmonthComponent } from './gregorian-nthkdayofmonth/gregorian-nthkdayofmonth.component';
import { ChineseComponent } from './chinese/chinese.component';
import { EcclesiasticalGregorianComponent } from './ecclesiastical-gregorian/ecclesiastical-gregorian.component';
import { EcclesiasticalOrthodoxComponent } from './ecclesiastical-orthodox/ecclesiastical-orthodox.component';
import { HebrewComponent } from './hebrew/hebrew.component';
import { HebrewSpecialComponent } from './hebrew-special/hebrew-special.component';
import { HinduLunarComponent } from './hindu-lunar/hindu-lunar.component';
import { HinduLunarMoonphaseComponent } from './hindu-lunar-moonphase/hindu-lunar-moonphase.component';
import { HinduLunarSpecialComponent } from './hindu-lunar-special/hindu-lunar-special.component';
import { HinduSolarComponent } from './hindu-solar/hindu-solar.component';
import { HinduSolarSpecialComponent } from './hindu-solar-special/hindu-solar-special.component';
import { IslamicComponent } from './islamic/islamic.component';
import { IslamicSpecialComponent } from './islamic-special/islamic-special.component';
import { RegionsComponent } from './regions/regions.component';
@NgModule({
  declarations: [
    AppComponent,
    //table component
    StatesComponent,
    EditHolidaysComponent,
    ShowHolidaysComponent,
    CountryComponent,
    ConcernsQuestionsComponent,
    CitiesComponent,
    HolidayNotesComponent,
    HolidaysLocalesDetailsComponent,
    FormulaNotesComponent,
    GregorianMonthdayMoonphaseComponent,
    GregorianMonthdayComponent,
    GregorianKdayafteretcMonthdayComponent,
    GregorianMonthdaySpecialComponent,
    GregorianNthkdayofmonthComponent,

    // helper component
    HolidaysLocalesDetailsAddDialog,
    HolidaysLocalesDetailsUpdateDialog,
    HolidaysLocalesDetailsAdvSearchDialog,

    AdvancedSearchDialogComponent,
    DeleteDialog,
    UpdateDialog,

    CommonDeleteDialog,
    CommonAddDialog,
    CommonUpdateDialog,
    CommonAdvSearchDialog,
    CommonErrorDialog,
    CommonComponent,
    ChineseComponent,
    EcclesiasticalGregorianComponent,
    EcclesiasticalOrthodoxComponent,
    HebrewComponent,
    HebrewSpecialComponent,
    HinduLunarComponent,
    HinduLunarMoonphaseComponent,
    HinduLunarSpecialComponent,
    HinduSolarComponent,
    HinduSolarSpecialComponent,
    IslamicComponent,
    IslamicSpecialComponent,
    RegionsComponent,

],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatSidenavModule,
    MatMenuModule,
    MatToolbarModule,
    MatCardModule,
    MatTableModule,
    MatPaginatorModule,
    MatListModule,
    MatDialogModule,
    MatInputModule,
    FormsModule,
    MatExpansionModule,
    MatSelectModule,
    MatFormFieldModule,
    MatSortModule,
    MatSelectModule,
    MatCheckboxModule
  ],

  entryComponents: [ HolidaysLocalesDetailsAddDialog,
    HolidaysLocalesDetailsUpdateDialog,DeleteDialog,UpdateDialog,HolidaysLocalesDetailsAdvSearchDialog,
    CommonDeleteDialog,CommonAddDialog,CommonUpdateDialog,CommonAdvSearchDialog,CommonErrorDialog
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
