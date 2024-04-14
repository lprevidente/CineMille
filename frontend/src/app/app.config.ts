import { ApplicationConfig, InjectionToken, LOCALE_ID } from "@angular/core";
import { provideRouter } from "@angular/router";
import { routes } from "./app.routes";
import { provideClientHydration } from "@angular/platform-browser";
import { provideAnimationsAsync } from "@angular/platform-browser/animations/async";
import { MAT_DATE_LOCALE } from "@angular/material/core";
import { environment } from "@assets/environments/environment";

export const BASE_PATH = new InjectionToken<string>("Base path for the API");

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideClientHydration(),
    provideAnimationsAsync(),
    { provide: MAT_DATE_LOCALE, useValue: "it-IT" },
    { provide: LOCALE_ID, useValue: "it-IT" },
    { provide: BASE_PATH, useValue: environment.basePath },
  ],
};
