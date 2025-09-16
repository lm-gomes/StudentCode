#include <stdio.h>
#include <stdlib.h>

int mdc(int a, int b){
	if (b == 0){
		if(a < 0)
			return -a;
		return a;
	}	
	return mdc(b, a % b);
}

int main(){
	int qtd = 0;
	int j = 0;

	int jump = 0;

	scanf("%d", &qtd);

	int *n = malloc(sizeof(int) * (qtd * 2));
	int *d = malloc(sizeof(int) * (qtd * 2));
	int *r = malloc(sizeof(int) * (qtd * 2));
	int *num = malloc(sizeof(int) * qtd);
	
	char *op = malloc(sizeof(char) * qtd);
	char *div = malloc(sizeof(char) * (qtd * 2));
	
	for(int i = 0; i < qtd; i++){
		jump = i + j;

		scanf("%d %c %d %c %d %c %d", &n[jump], &div[jump], &d[jump], &op[i], &n[jump + 1], &div[jump + 1], &d[jump + 1]);
		

		if(op[i] == '+'){
			r[jump] = (n[jump] * d[jump + 1]) + (n[jump + 1] * d[jump]); 
			r[jump + 1] = d[jump] * d[jump + 1]; 
		}

		else if(op[i] == '-'){
			r[jump] = (n[jump] * d[jump + 1]) - (n[jump + 1] * d[jump]);
			r[jump + 1] = d[jump] * d[jump + 1];
		}
		
		else if(op[i] == '*'){
			r[jump] = n[jump] * n[jump + 1];
			r[jump + 1] = d[jump] * d[jump + 1];	
		}
		else{
			r[jump] = n[jump] * d[jump + 1];			r[jump + 1] = d[jump] * n[jump + 1];		
		}
		num[i] = mdc(r[jump], r[jump + 1]);

		j++;
	}
	
	j = 0;
	for(int i = 0; i < qtd; i++){
		jump = i + j;
		printf("%d/%d = %d/%d\n", r[jump], r[jump + 1], r[jump] / num[i], r[jump + 1] / num[i]);
		j++;
	}

	return 0;
}