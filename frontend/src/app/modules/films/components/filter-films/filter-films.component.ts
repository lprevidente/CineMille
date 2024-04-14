import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Output,
} from "@angular/core";
import { FilterFormGroup } from "@modules/films/forms/filter.form-group";
import { takeUntilDestroyed } from "@angular/core/rxjs-interop";
import { debounceTime, filter, map } from "rxjs";
import { FilmCriteria } from "@modules/films/models/film";

@Component({
  selector: "app-filter-films",
  templateUrl: "./filter-films.component.html",
  styleUrl: "./filter-films.component.scss",
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class FilterFilmsComponent {
  protected readonly filterForm = new FilterFormGroup();

  @Output()
  public filterChange = new EventEmitter<FilmCriteria>();

  constructor() {
    this.filterForm.valueChanges
      .pipe(
        takeUntilDestroyed(),
        debounceTime(300),
        filter(() => this.filterForm.valid),
        map(() => this.filterForm.getRawValue())
      )
      .subscribe(value => this.filterChange.emit(value));
  }

  protected get f() {
    return this.filterForm.controls;
  }
}
