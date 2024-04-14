import { ChangeDetectionStrategy, Component, signal } from "@angular/core";
import { FilmService } from "@modules/films/services/film.service";
import { Film, FilmCriteria, filmTrackBy, filter } from "../../models/film";

@Component({
  selector: "app-all-films",
  templateUrl: "./all-films.component.html",
  styleUrl: "./all-films.component.scss",
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AllFilmsComponent {
  protected readonly loading = signal<boolean>(true);
  protected readonly error = signal<boolean>(false);
  protected allFilms: Film[] = [];
  protected readonly films = signal<Film[]>([]);
  protected readonly filmTrackBy = filmTrackBy;

  public constructor(private _filmService: FilmService) {
    this._filmService
      .getFilmsOnShown()
      .subscribe({
        next: films => {
          this.allFilms = films;
          this.films.set(films);
        },
        error: () => this.error.set(true),
      })
      .add(() => this.loading.set(false));
  }

  protected filterFilms(filters: FilmCriteria): void {
    const filtered = this.allFilms.filter(film => filter(film, filters));
    this.films.set(filtered);
  }
}
