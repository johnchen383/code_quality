package smells;

/**
 * Class listing all non-relational code smells. That is code smells that do not
 * depend on another class and its interaction with it. This is as I think it's
 * more likely that a single method will be given for us to refactor in
 * assessments.
 */
public class NonRelational {
    /**
     * ABUSERS:
     * - Temporary Field
     * - Switch statements OR long if's
     */

    /**
     * BLOATERS:
     * - Long Method
     * - Long Parameter List
     * - Primitive Obsession
     * - Data Clumps
     */

    /**
     * COUPLERS:
     * - Message Chains
     */

    /**
     * DISPENSABLES:
     * - Speculative Generality
     * - Duplicated Code
     */

    /**
     * CHANGE PREVENTERS:
     * - Divergent Change
     */

    /**
     * Just in case, it's needed ahah
     */
    public class Relational {
        /**
         * ABUSERS:
         * - Alternative Classes [doing the same thing]
         * - Refused Bequest [unneeded inheritance]
         */

        /**
         * BLOATERS:
         * - Large Class
         */

        /**
         * COUPLERS:
         * - Middle Man
         * - Feature Envy
         * - Inappropriate Intimacy
         */

        /**
         * DISPENSABLES:
         * - Lazy Class
         * - Data Class
         */
        
        /**
         * CHANGE PREVENTERS:
         * - Shotgun Surgery
         * - Parallel Inheritance Heirarchies
         */
        
    }
}
