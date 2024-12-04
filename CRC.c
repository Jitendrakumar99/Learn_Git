#include <stdio.h>
#include <string.h>

int main() {
    int i, j, k, m, n, cl;
    char a[10], b[100], c[100];

    printf("\n ENTER POLYNOMIAL: ");
    scanf("%s", a);

    printf("\n ENTER THE FRAME: ");
    scanf("%s", b);

    m = strlen(a);
    n = strlen(b);

    // Remove leading zeros from the polynomial
    for (i = 0; i < m; i++) {
        if (a[i] == '1') {
            break;
        }
    }
    for (k = 0; k < m - i; k++) {
        a[k] = a[k + i];
    }
    m -= i; // Update polynomial length

    cl = m + n - 1;

    // Append zeros to the frame
    for (i = 0; i < n; i++) {
        c[i] = b[i];
    }
    for (i = n; i < cl; i++) {
        c[i] = '0';
    }
    c[cl] = '\0'; // Null-terminate the extended frame

    // Perform XOR-based division
    for (i = 0; i < n; i++) {
        if (c[i] == '1') {
            for (j = 0; j < m; j++) {
                c[i + j] = (c[i + j] == a[j]) ? '0' : '1'; // XOR operation
            }
        }
    }

    // Combine frame and remainder
    for (i = 0; i < n; i++) {
        c[i] = b[i]; // Restore original frame
    }

    printf("\n THE MESSAGE IS: %s", c);

    return 0;
}
