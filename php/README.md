# PHP Data Structures and Algorithms

Standard 
https://www.php.net/manual/en/spl.datastructures.php

## Array
https://www.php.net/manual/pt_BR/language.types.array.php

+ Ordered map
+ Incremented and Optional Key

http://johnciacia.com/2011/02/01/array-vs-splfixedarray/

## Linked List

# Project Settings

## Composer
https://getcomposer.org/doc/01-basic-usage.md

## PHPUNIT
https://phpunit.de/getting-started/phpunit-8.html

```bash
./vendor/bin/phpunit tests/
```

![PHPStorm](phpunit-phpstorm.png)

## Code Sniffer
https://github.com/squizlabs/PHP_CodeSniffer

```bash
vendor/bin/phpcs --standard=psr12 -p src
```

### Fixing
```bash
vendor/bin/phpcbf --standard=psr12 -p src
```

## PHPStan
https://github.com/phpstan/phpstan

```bash
./vendor/bin/phpstan analyse src/ --level 8
```

