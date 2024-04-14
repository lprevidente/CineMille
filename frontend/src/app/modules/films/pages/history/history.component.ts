import { ChangeDetectionStrategy, Component, signal } from "@angular/core";
import { Film, FilmCriteria, filmTrackBy } from "@modules/films/models/film";
import { FilmService } from "@modules/films/services/film.service";

@Component({
  selector: "app-history",
  templateUrl: "./history.component.html",
  styleUrl: "./history.component.scss",
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class HistoryComponent {
  protected readonly loading = signal<boolean>(true);
  protected readonly error = signal<boolean>(false);
  protected readonly films = signal<Film[]>([]);
  protected readonly filmTrackBy = filmTrackBy;

  public constructor(private _filmService: FilmService) {
    this._filmService
      .getHistory()
      .subscribe({
        next: films => this.films.set(films),
        error: () => this.error.set(true),
      })
      .add(() => this.loading.set(false));
  }

  protected filterFilms(filters: FilmCriteria): void {
    console.log(filters);
    this._filmService.getHistory(filters).subscribe({
      next: films => this.films.set(films),
      error: () => this.error.set(true),
    });
  }
}
