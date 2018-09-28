#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    
    int n;
    int* target;
    int isLast;

} thread_arg;



int fib(void* argp){

	thread_arg* targp = (thread_arg*)argp;


	if(targp->n == 0){

		targp->target[targp->n] = 0;
		return 0;
	} else if (targp->n == 1){

		targp->target[targp->n] = 1;
		return 1;

	}



	thread_arg* targp1 = (thread_arg*)malloc(sizeof(thread_arg));
	thread_arg* targp2 = (thread_arg*)malloc(sizeof(thread_arg));

	targp1->target = targp->target;
	targp1->n = (targp->n) - 1;
	targp1->isLast = 0;

	targp2->target = targp->target;
	targp2->n = (targp->n) - 2;
	targp2->isLast = 0;

	int res = fib((void*)targp1) + fib((void*)targp2);

	targp1->target[targp1->n] = res;

	if(targp->isLast == 1){

		pthread_exit((void *)NULL);

	}

	return res;

}



int main(int argc, char** argv){

	if(argc < 2){

		printf("No enough args!\n");
		return EXIT_FAILURE;

	}

	char* nString = argv[1];

	int n = atoi(nString);

	int* target = (int*)malloc(n*sizeof(int));

	thread_arg*  args = (thread_arg*)malloc(sizeof(thread_arg));

	args->n = n;
	args->target = target;
	args->isLast = 1;

	pthread_t tid;



	pthread_create(&tid, NULL, fib,(void*)args);
	pthread_join(tid, NULL);

	for(int i = 0; i < n; i++){

		printf("%d ", args->target[i]);


	}

	printf("\n");

	//pthread_exit((void *)NULL);

}