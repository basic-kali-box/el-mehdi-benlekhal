import { Component } from '@angular/core';

@Component({
    selector: 'app-root',
    template: `
    <div style="text-align:center" class="content">
      <h1>Welcome to {{title}}!</h1>
      <p>This is a placeholder for the Angular Frontend.</p>
      <p>In a real scenario, this would contain components to list Conferences and Keynotes.</p>
    </div>
  `,
    styles: []
})
export class AppComponent {
    title = 'angular-front-app';
}
