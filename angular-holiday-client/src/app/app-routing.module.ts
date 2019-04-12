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
import {ChineseComponent} from "./chinese/chinese.component";
import {EcclesiasticalGregorianComponent} from "./ecclesiastical-gregorian/ecclesiastical-gregorian.component";
import {EcclesiasticalOrthodoxComponent} from "./ecclesiastical-orthodox/ecclesiastical-orthodox.component";
import {HebrewComponent} from "./hebrew/hebrew.component";
import {HebrewSpecialComponent} from "./hebrew-special/hebrew-special.component";
import {HinduLunarComponent} from "./hindu-lunar/hindu-lunar.component";
import {HinduLunarMoonphaseComponent} from "./hindu-lunar-moonphase/hindu-lunar-moonphase.component";
import {HinduLunarSpecialComponent} from "./hindu-lunar-special/hindu-lunar-special.component";
import {OldHinduLunarComponent} from "./old-hindu-lunar/old-hindu-lunar.component";
import {OldHinduLunarMoonphaseComponent} from "./old-hindu-lunar-moonphase/old-hindu-lunar-moonphase.component";
import {OldHinduLunarSpecialComponent} from "./old-hindu-lunar-special/old-hindu-lunar-special.component";
import {HinduSolarComponent} from "./hindu-solar/hindu-solar.component";
import {HinduSolarSpecialComponent} from "./hindu-solar-special/hindu-solar-special.component";
import {IslamicComponent} from "./islamic/islamic.component";
import {IslamicSpecialComponent} from "./islamic-special/islamic-special.component";
import {RegionsComponent} from "./regions/regions.component";

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
  { path: 'gregorianNthkdayofmonth',component: GregorianNthkdayofmonthComponent},
  { path: 'chinese',component: ChineseComponent},
  { path: 'ecclesiasticalGregorian',component: EcclesiasticalGregorianComponent},
  { path: 'ecclesiasticalOrthodox',component: EcclesiasticalOrthodoxComponent},
  { path: 'hebrew',component: HebrewComponent},
  { path: 'hebrewSpecial',component: HebrewSpecialComponent},
  { path: 'hinduLunar',component: HinduLunarComponent},
  { path: 'hinduLunarMoonphase',component: HinduLunarMoonphaseComponent},
  { path: 'hinduLunarSpecial',component: HinduLunarSpecialComponent},
  { path: 'oldHinduLunar',component: OldHinduLunarComponent},
  { path: 'oldHinduLunarMoonphase',component: OldHinduLunarMoonphaseComponent},
  { path: 'oldHinduLunarSpecial',component: OldHinduLunarSpecialComponent},
  { path: 'hinduSolar',component: HinduSolarComponent},
  { path: 'hinduSolarSpecial',component: HinduSolarSpecialComponent},
  { path: 'islamic',component: IslamicComponent},
  { path: 'islamicSpecial',component: IslamicSpecialComponent},
  { path: 'regions',component: RegionsComponent}
];

@NgModule({
  // initialize the router and start it listening for browser location changes.
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
