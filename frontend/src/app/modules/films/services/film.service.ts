import { Inject, Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { BASE_PATH } from "@app/app.config";
import { Observable } from "rxjs";
import { Film, FilmCriteria, rangeToJson } from "@modules/films/models/film";

@Injectable()
export class FilmService {
  private readonly _endpoint: string;

  constructor(
    private _httpClient: HttpClient,
    @Inject(BASE_PATH) private basePath: string
  ) {
    this._endpoint = `${this.basePath}/v1/films`;
  }

  getFilmsOnShown(): Observable<Film[]> {
    const params = new HttpParams().append("on_shown", "true");
    return this._httpClient.get<Film[]>(this._endpoint, { params });
  }

  getHistory(filters?: FilmCriteria): Observable<Film[]> {
    let params = new HttpParams().append("on_shown", "false");
    if (filters?.text) params = params.append("text", filters.text);
    if (filters?.range.start && filters?.range.end) {
      const json = rangeToJson(filters.range);
      params = params.append("range", json);
    }
    return this._httpClient.get<Film[]>(this._endpoint, { params });
  }
}
