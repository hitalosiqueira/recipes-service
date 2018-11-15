INSERT INTO INGREDIENT (INGREDIENT_NAME)
VALUES ('sal'), ('açucar'),
       ('farinha'), ('chocolate em pó'),
       ('ovo'), ('leite'),
       ('fermento'), ('água'),
       ('manteiga'), ('leite condensado'), ('óleo de soja');

INSERT INTO RECIPE (RECIPE_NAME, PORTIONS, CALORIES, INSTRUCTIONS)
VALUES('Brigadeiro', 4, 500, 'Em uma panela misture os ingredientes e mexa em fogo baixo até atingir a consistência'),
      ('Ovo frito', 1, 300, 'Em uma frigideira, quebre o ovo e frite no óleo em fogo baixo por 3 minutos');

INSERT INTO RECIPE_INGREDIENT (RECIPE_ID, INGREDIENT_ID, AMOUNT)
VALUES (1, 4, 'quatro colheres de sopa'),
       (1, 10, 'uma lata'),
       (1, 9, 'uma colher de sopa'),
       (2, 5, 'uma unidade'),
       (2, 11, 'um fio');
