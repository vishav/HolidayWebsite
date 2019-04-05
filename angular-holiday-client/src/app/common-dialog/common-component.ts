import {Component, Inject} from "@angular/core";
import {MatDialogRef, MAT_DIALOG_DATA} from "@angular/material";
@Component({
  selector: 'common-delete-dialog',
  templateUrl: 'delete-dialog.html',
})
export class  CommonDeleteDialog {

  constructor(public dialogRef: MatDialogRef<CommonDeleteDialog>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              @Inject(MAT_DIALOG_DATA) public fields: string[]){}


  onNoClick(): void {
    console.log("cancel delete");
    this.dialogRef.close("cancel");
  }

  onDeleteClick(): void {
    console.log("on submit click" );
    this.dialogRef.close("submit");
  }

}

@Component({
  selector: 'common-add-dialog',
  templateUrl: 'add-dialog.html',
})
export class  CommonAddDialog {

  constructor(
    public dialogRef: MatDialogRef<CommonAddDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    @Inject(MAT_DIALOG_DATA) public fields: string[]) {}


  onNoClick(): void {
    console.log("add:  on no click", this.data);
    //console.log("fields ", this.data.fields[0]);
    this.dialogRef.close("cancel");
  }

  onAddClick(): void {
    console.log("on add click", this.data);
    this.dialogRef.close("submit");
  }
}

@Component({
  selector: 'common-update-dialog',
  templateUrl: 'update-dialog.html',
})

export class  CommonUpdateDialog {

  constructor(public dialogRef: MatDialogRef<CommonUpdateDialog>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              @Inject(MAT_DIALOG_DATA) public fields: string[]) {
  }

  onNoClick(): void {
    console.log("Update:  on no click", this.data);
    //console.log("fields ", this.data.fields[0]);
    this.dialogRef.close("cancel");
  }

  onUpdateClick(): void {
    console.log("on update click", this.data);
    this.dialogRef.close("submit");
  }
}


@Component({
  selector: 'common-adv-search-dialog',
  templateUrl: 'adv-search-dialog.html',
})
export class  CommonAdvSearchDialog {

  constructor(
    public dialogRef: MatDialogRef<CommonAdvSearchDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any){}

  fileterSearch : any;
  selectFields = {country :["China", "Canada", "United States of America"],
  };

  mappingFields = {
    country : {
      "China": 12,
      "United States of America": 70,
      "Canada": 9
    }

  }
  choices = {
    countries: ["China", "Canada", "United States of America"],
    religion:  ["Chinese", "Moslem","Christan"]
  }

  onNoClick(): void {
    //console.log("on no click", this.data);
    console.log("data ", this.data);
    this.dialogRef.close("cancel");
  }

  onAdvSearchClick(): void {
    //console.log("on submit click", this.data);
    this.dialogRef.close("submit");
  }



}

@Component({
  selector: 'common-error-dialog',
  templateUrl: 'error-dialog.html',
})

export class  CommonErrorDialog {

  constructor(public dialogRef: MatDialogRef<CommonErrorDialog>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              @Inject(MAT_DIALOG_DATA) public fields: string[]) {
  }

  onOkayClick(): void {
    console.log("Update:  on no click", this.data);
    //console.log("fields ", this.data.fields[0]);
    this.dialogRef.close("cancel");
  }

  onUpdateClick(): void {
    console.log("on update click", this.data);
    this.dialogRef.close("submit");
  }
}
