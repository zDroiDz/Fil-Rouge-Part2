#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../SEARCH/by_keyword.h"
#include "../INDEXATION/index_txt.h"
#include "../INDEXATION/index_sound.h"
#include "../INDEXATION/index_img.h"
#include "menu.h"

int main(int argc, char const *argv[]) {
  /* code */

  FILE * testouvertureconfig = fopen("../EXTERN_FILES/configuration.config","r");

  if (testouvertureconfig == NULL) {
    FILE * ouvertureconfig = fopen("../EXTERN_FILES/configuration.config","w");
    fprintf(ouvertureconfig, "%s",  "<txt>\ntxt_nboccurrences: 3\n</txt>\n\n<sound>\nechantillions: 2048\nnbintervalles: 40\n</sound>\n\n<image>\nNbBit_NB: 4\nNbBit_RGB: 3\n</image>");
    printf("Fichier de config inexistant. Création du fichier avec des valeurs par défaut.\n");
    if (ouvertureconfig != NULL) {
      fclose(ouvertureconfig);
    }
  }else{
    if (testouvertureconfig != NULL) {
      fclose(testouvertureconfig);
    }
  }

  if(strcmp(argv[1],"indexation")==0)
  {
    rmThenStartIndexation();
    indexImage();
    resetAndIndex();
  }
  else if(strcmp(argv[1],"comparaison")==0)
  {
    if(strcmp(argv[2],"texte")==0)
    {
      indexFileToCompare(argv[3]);
    }
    if(strcmp(argv[2],"son")==0)
    {
      compare(argv[3]);
    }
    if(strcmp(argv[2],"image")==0)
    {
      searchImage(argv[3]);
    }

  }
  return 0;

}
