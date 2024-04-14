import { FormControl, FormGroup } from "@angular/forms";

export class FilterFormGroup extends FormGroup<{
  text: FormControl<string | null>;
  range: FormGroup<{
    start: FormControl<Date | null>;
    end: FormControl<Date | null>;
  }>;
}> {
  constructor() {
    super({
      text: new FormControl<string | null>(null),
      range: new FormGroup({
        start: new FormControl<Date | null>(null),
        end: new FormControl<Date | null>(null),
      }),
    });
  }
}
