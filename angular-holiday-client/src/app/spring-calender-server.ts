// Generated using typescript-generator version 2.0.400 on 2018-11-29 20:41:41.

export class Country {
    id: number;
    name: string;
}

export class HolidaysLocalesDetails {
    id: number;
    holiday: number;
    city: number;
    state: number;
    country: number;
    formulatablename: string;
    formulaid: number;
    observanceruleid: number;
    numberofdays: number;
    formulanoteid: number;
    holidaynoteid: number;
    concernquestionid: number;
    businessesclosed: string;
    banksclosed: string;
    religiousholiday: string;
    dis: string;
    holidaytype: string;
    religion: string;
    metroarea: string;
    checkmanually: string;
}

export class State {
    id: number;
    name: string;
    country: number;
}

export class Holiday {
  id: number;
  name: string;
}
export class ConcernsQuestions {
  id: number;
  concernQuestion: string;
}

export class City {
  id: number;
  name: string;
  state: number;
  country: number;
}

export class HolidayNotes {
  id: number;
  holidayNote: string;
}

export class FormulaNotes {
  id: number;
  formulaNote: string;
}

export class GregorianNthkdayofmonth {
  id: number;
  nth: number;
  kday: number;
  month: number;
  offset: number;
}

export class GregorianKdayafteretcMonthday {
  id: number;
  kday: number;
  afteretc: string;
  month: number;
  day: number;
  offset: number;
}

export class GregorianMonthday {
  id: number;
  month: number;
  day: number;
  offset: number;
  leapyearadjust: number;
}

export class GregorianMonthdayMoonphase {
  id: number;
  month: number;
  day: number;
  moonphase: string;
  location: string;
  offset: number;
}

export class GregorianMonthdaySpecial {
  id: number;
  month: number;
  day: number;
  offset: number;
  leapyearadjust: number;
  description: string;
}
