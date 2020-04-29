package test.example;

public class Massivah {

    private static class KeyWithArray {
        private String key;
        private String[] array;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String[] getArray() {
            return array;
        }


        public KeyWithArray(String key, String[] array) {
            this.key = key;
            this.array = array;
        }

        public boolean merge(String[] arrayToMerge) {
            boolean result = false;
            marker:
            for (String item : arrayToMerge) {
                for (String initItem : this.array) {
                    if (item.equals(initItem)) {
                        result = true;
                        break marker;
                    }
                }
            }

            if (!result) {
                return false;
            }

            String[] bufferArray = new String[array.length + arrayToMerge.length];
            System.arraycopy(array, 0, bufferArray, 0, array.length);
            System.arraycopy(arrayToMerge, 0, bufferArray, array.length, arrayToMerge.length);
            bufferArray = filter(bufferArray);
            this.array = bufferArray;
            return true;
        }

        private String[] filter(String[] source) {
            String[] resultArray = new String[0];
            marker:
            for (int i = 0; i < source.length; i++) {
                String temp = source[i];
                for (String element : resultArray) {
                    if (element.equals(temp)) {
                        continue marker;
                    }
                }

                String[] bufferArray = new String[resultArray.length + 1];
                System.arraycopy(resultArray, 0, bufferArray, 0, resultArray.length);
                bufferArray[bufferArray.length - 1] = temp;
                resultArray = bufferArray;
            }
            return resultArray;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(key);
            builder.append(" ==> ");
            for (String item : array) {
                builder.append(item);
                builder.append(", ");
            }

            return builder
                    .replace(builder.length() - 2, builder.length() - 1, "")
                    .toString();
        }
    }

    public static void main(String[] args) {

        KeyWithArray[] users = {
                new KeyWithArray("user1", "xxx@ya.ru,foo@gmail.com,lol@mail.ru".split(",")),
                new KeyWithArray("user2", "foo@gmail.com,ups@pisem.net".split(",")),
                new KeyWithArray("user3", "xyz@pisem.net,vasya@pupkin.com".split(",")),
                new KeyWithArray("user4", "ups@pisem.net,aaa@bbb.ru".split(",")),
                new KeyWithArray("user5", "xyz@pisem.net".split(","))
        };

//        System.out.println("=========================================================");
//
//        for (KeyWithArray user : users) {
//            System.out.println(user);
//        }
//
//        System.out.println("=========================================================");
//
//        for (KeyWithArray user : convert(users)) {
//            System.out.println(user);
//        }
//
//        System.out.println("=========================================================");

        somePublicMethod(users);


    }

    static KeyWithArray[] convert(KeyWithArray[] users) {
        for (int i = 0; i < users.length - 1; i++) {
            for (int j = i + 1; j < users.length; j++) {
                if (users[j].merge(users[i].getArray())) {
                    users[j].setKey(users[i].getKey());
                    users[i].setKey(null);
                }
            }
        }

        int resultLength = 0;
        for (KeyWithArray user : users) {
            if (user.getKey() != null) {
                resultLength++;
            }
        }

        KeyWithArray[] result = new KeyWithArray[resultLength];

        int i = 0;
        for (KeyWithArray user : users) {
            if (user.getKey() != null) {
                result[i] = user;
                i++;
            }
        }

        return result;
    }

    public  static void somePublicMethod(KeyWithArray[] users) {
        long startTime = 0;
        long endTime = 0;
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 100_000_000; i++) {
            convert(users);
        }
        endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}