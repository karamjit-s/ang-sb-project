import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RouterTabs } from './router-tab/router-tabs.directive';
import { RouterTab } from './router-tab/router-tab.directive';

@NgModule({
  imports: [CommonModule, RouterModule],
  declarations: [PageNotFoundComponent, RouterTabs, RouterTab],
  exports: [
    CommonModule,
    PageNotFoundComponent,
    RouterTabs,
    RouterTab
  ]
})
export class SharedModule {}
