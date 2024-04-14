import { ScreeningInfo } from "@modules/films/models/screening-film";

export interface Film {
  id: number;
  title: string;
  description: string;
  releaseDate: string;
  durationInMinutes: number;
  screenings: { [date: string]: ScreeningInfo[] };
}

export const filmTrackBy = (_: number, film: Film): number => film.id;

export type Range = { start: Date | null; end: Date | null };

export const rangeToJson = (range: Range): string => {
  return JSON.stringify({
    start: toString(range.start),
    end: toString(range.end),
  });
};

export const toString = (date: Date | null) =>
  date
    ?.toLocaleDateString("en-CA", {
      day: "2-digit",
      month: "2-digit",
      year: "numeric",
    })
    .replace(/\//g, "-") ?? "";

export interface FilmCriteria {
  text: string | null;
  range: Range;
}

function textMatch(text: string | undefined | null, film: Film): boolean {
  const textLowerCase = text?.toLowerCase().trim() ?? "";
  const title = film.title.toLowerCase();
  const description = film.description.toLowerCase();
  return title.includes(textLowerCase) || description.includes(textLowerCase);
}

function rangeMatch(range: Range | null | undefined, film: Film): boolean {
  if (!range) return true;
  return Object.keys(film.screenings).some(dateStr => {
    const date = new Date(dateStr);
    return (
      (!range.start || date >= range.start) && (!range.end || date <= range.end)
    );
  });
}

export function filter(film: Film, criteria: FilmCriteria): boolean {
  const matchText = textMatch(criteria.text, film);
  const matchRange = rangeMatch(criteria.range, film);
  return matchText && matchRange;
}
