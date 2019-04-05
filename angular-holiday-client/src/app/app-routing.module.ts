import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditHolidaysComponent } from './holidays/edit-holidays/edit-holidays.component';
import {ShowHolidaysComponent} from './holidays/show-holidays/show-holidays.component';
import {HolidaysLocalesDetailsComponent} from './holidays-locales-details/holidays-locales-details.component';
import {ConcernsQuestionsComponent} from "./concerns-questions/concerns-questions.component";
import {CountryComponent} from "./country/country.component";
import {StatesComponent} from "./states/states.component";
import {CitiesComponent} from "./cities/cities.component";
import {HolidayNotesComponent} from "./holiday-notes/holiday-notes.component";
import {FormulaNotesComponent} from "./formula-notes/formula-notes.component";
import {GregorianMonthdayMoonphaseComponent} from "./gregorian-monthday-moonphase/gregorian-monthday-moonphase.component";
import {GregorianMonthdayComponent} from "./gregorian-monthday/gregorian-monthday.component";
import {GregorianKdayafteretcMonthdayComponent} from "./gregorian-kdayafteretc-monthday/gregorian-kdayafteretc-monthday.component";
import {GregorianMonthdaySpecialComponent} from "./gregorian-monthday-special/gregorian-monthday-special.component";
import {GregorianNthkdayofmonthComponent} from "./gregorian-nthkdayofmonth/gregorian-nthkdayofmonth.component";
const routes: Routes = [
  { path: '', redirectTo: 'showHolidays', pathMatch: 'full' },
  { path: 'showHolidays', component: ShowHolidaysComponent },
  { path: 'holidays', component: EditHolidaysComponent },
  { path: 'holidaysLocalesDetails', component: HolidaysLocalesDetailsComponent },
  { path: 'concernsQuestions', component: ConcernsQuestionsComponent },
  { path: 'countries', component: CountryComponent },
  { path: 'states', component: StatesComponent },
  { path: 'cities', component: CitiesComponent },
  { path: 'holidayNotes', component: HolidayNotesComponent },
  { path: 'formulaNotes', component: FormulaNotesComponent },
  { path: 'gregorianMonthday', component:GregorianMonthdayComponent},
  { path: 'gregorianMonthdayMoonphase', component:GregorianMonthdayMoonphaseComponent},
  { path: 'gregorianKdayafteretcMonthday',component: GregorianKdayafteretcMonthdayComponent},
  { path: 'gregorianMonthdaySpecial',component: GregorianMonthdaySpecialComponent},
  { path: 'gregorianNthkdayofmonth',component: GregorianNthkdayofmonthComponent}
];

@NgModule({
  // initialize the router and start it listening for browser location changes.
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
