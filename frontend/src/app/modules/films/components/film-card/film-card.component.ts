import { ChangeDetectionStrategy, Component, input } from "@angular/core";
import { Film } from "@modules/films/models/film";

@Component({
  selector: "app-film-card",
  templateUrl: "./film-card.component.html",
  styleUrl: "./film-card.component.scss",
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class FilmCardComponent {
  public film = input.required<Film>();

  protected formatDuration(durationInMinutes: number): string {
    const hours = Math.floor(durationInMinutes / 60);
    const minutes = durationInMinutes % 60;
    return `${hours}h ${minutes}m`;
  }

  protected getDates(film: Film) {
    return Object.keys(film.screenings);
  }

  protected readonly trackByDate = (_: number, date: string) => date;
  protected readonly trackByTime = (_: number, time: string) => time;
}
