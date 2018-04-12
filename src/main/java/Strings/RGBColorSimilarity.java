package Strings;

/**
 * CSS colors can be defined in the hexadecimal notation "#rgb", a shorthand for "#rrggbb".
 * For example, "#03f" is equivalent to "#0033ff". Suppose the similarity between two colors "#abcdef" and "#ghijkl"
 * is defined as (-(ab-gh)^2 - (cd-ij)^2 - (ef-kl)^2), write a function that accepts a color in the "#abcdef"
 * format and returns a "#rgb" color that is most similar to the input. For example, given "#09f166", "#1e6"
 * should be returned.
 */
public class RGBColorSimilarity {
    public static void main(String[] args) {
        String rgb = "#09f166";
        System.out.println(shorten(rgb));
    }

    private static String shorten(String rgb) {
        String r = nearestDouble(rgb.substring(1, 3));
        String g = nearestDouble(rgb.substring(3, 5));
        String b = nearestDouble(rgb.substring(5, 7));

        return "#" + r + g + b;
    }

    private static int[] doubles = {0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xaa,
                                    0xbb, 0xcc, 0xdd, 0xee, 0xff};
    private static String nearestDouble(String str) {
        if(str.charAt(0) == str.charAt(1)) return str.substring(0, 1);

        int num = Integer.parseInt(str, 16);
        int min_diff = 16;
        int min = -1;
        for(int i: doubles){
            if(Math.abs(i-num) < min_diff){
                min_diff = Math.abs(i-num);
                min = i;
            }
        }
        return String.format("%X", min).substring(0, 1).toLowerCase();
    }

    /*
    shorten(color):
        color = int(color, 16)
        lower = (color / 0x11) * 0x11
        higher = ((color / 0x11) + 1) * 0x11

        if (color - lower) < (higher - color):
            return hex(lower)[3]
        else:
            return hex(higher)[3]
     */

}
