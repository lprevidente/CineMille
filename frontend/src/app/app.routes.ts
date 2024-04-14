import { Routes } from '@angular/router';
import { ContentComponent } from './layout/content/content.component';

export const routes: Routes = [
  { path: '', redirectTo: 'films', pathMatch: 'full' },
  {
    path: '', component: ContentComponent, children: [
      {
        path: 'films',
        loadChildren: () => import('./modules/films/films.module').then(m => m.FilmsModule),
      },
    ],
  },
  { path: '**', redirectTo: 'films' },
];
