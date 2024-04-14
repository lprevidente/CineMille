import { NgModule } from "@angular/core";
import { CommonModule, registerLocaleData } from "@angular/common";

import { FilmsRoutingModule } from "./films-routing.module";
import { AllFilmsComponent } from "./pages/all-films/all-films.component";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatButtonModule } from "@angular/material/button";
import { MatIconModule } from "@angular/material/icon";
import { FilmCardComponent } from "./components/film-card/film-card.component";
import { MatCardModule } from "@angular/material/card";
import { MatChipsModule } from "@angular/material/chips";
import { MatFormField, MatInput } from "@angular/material/input";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { provideNativeDateAdapter } from "@angular/material/core";
import it from "@angular/common/locales/it";
import { MatTooltipModule } from "@angular/material/tooltip";
import { HistoryComponent } from "./pages/history/history.component";
import { LoadingCardsComponent } from "@shared/loading-cards/loading-cards.component";
import { FilterFilmsComponent } from "./components/filter-films/filter-films.component";
import { HttpClientModule } from "@angular/common/http";
import { FilmService } from "@modules/films/services/film.service";

registerLocaleData(it);

@NgModule({
  declarations: [
    AllFilmsComponent,
    FilmCardComponent,
    HistoryComponent,
    FilterFilmsComponent,
  ],
  imports: [
    HttpClientModule,
    CommonModule,
    FilmsRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatChipsModule,
    MatInput,
    MatFormField,
    MatFormFieldModule,
    MatDatepickerModule,
    FormsModule,
    ReactiveFormsModule,
    MatTooltipModule,
    LoadingCardsComponent,
  ],
  providers: [provideNativeDateAdapter(), FilmService],
})
export class FilmsModule {}
