CREATE TABLE RECIPE(
  ID INTEGER NOT NULL AUTO_INCREMENT,
  RECIPE_NAME VARCHAR NOT NULL,
  PORTIONS INTEGER NOT NULL,
  CALORIES INTEGER NOT NULL,
  INSTRUCTIONS VARCHAR (500),
  PRIMARY KEY (id)
);

CREATE TABLE INGREDIENT(
  ID INTEGER NOT NULL AUTO_INCREMENT,
  INGREDIENT_NAME VARCHAR (50),
  PRIMARY KEY (ID)
);

CREATE TABLE RECIPE_INGREDIENT(
  RECIPE_ID INTEGER NOT NULL,
  INGREDIENT_ID INTEGER NOT NULL,
  AMOUNT VARCHAR (50),
  FOREIGN KEY (RECIPE_ID) REFERENCES RECIPE(ID),
  FOREIGN KEY (INGREDIENT_ID) REFERENCES INGREDIENT(ID)
);