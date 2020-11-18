describe('Upper case app', function () {

    it('redirects to uppercase view on submitted user input', function() {
        cy.visit('localhost:8080/')
        cy.get('[data-test=input]')
          .type("test")
        cy.get('[data-test=submit]')
          .click()
        cy.url()
          .should('include', 'uppercase')
        cy.get('[data-test=upper-case-result]')
          .should('contain', 'TEST')
        cy.get('[data-test=back]')
          .click()
        cy.url()
          .should('eq', 'http://localhost:8080/')
    })

})