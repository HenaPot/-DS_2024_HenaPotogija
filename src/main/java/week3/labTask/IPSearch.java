package week3.labTask;

public class IPSearch {
    public static IPAddress search(IPAddress[] ipAddresses, String ipAddress) {
        int low = 0;
        int high = ipAddresses.length - 1;

        while (low <= high) {
            int mid = low + (high - low) /2;
            long ipNumber = ipToLong(ipAddress);

            if (ipNumber < ipAddresses[mid].getStartIp()) {
                high = mid - 1;
            } else if (ipNumber > ipAddresses[mid].getEndIp()) {
                low = mid + 1;
            } else {
                return ipAddresses[mid];
            }
        }
        return null;
    }

    public static String longToIP(long ipNumber) {
        long w = (ipNumber / 16777216) % 256;
        long x = (ipNumber / 65536) % 256;
        long y = (ipNumber / 256) % 256;
        long z = ipNumber % 256;
        return w + "." + x + "." + y + "." + z;
    }

    public static long ipToLong(String ipAddress) {
        String[] octets = ipAddress.split("\\.");
        return 16777216L * Integer.parseInt(octets[0]) +
                65536L * Integer.parseInt(octets[1]) +
                256L * Integer.parseInt(octets[2]) +
                Integer.parseInt(octets[3]);
    }

    /*public static void main(String[] args) {
        String myFilePath = "G:\\Faks 4\\Data Structures\\DS Labs\\Data_Structures_Labs\\IP2LOCATION.csv";
        IPAddress[] adrese = FileUtils.readFile(myFilePath);

        System.out.println(search(adrese,"202.3.4.1"));

    }*/
}


