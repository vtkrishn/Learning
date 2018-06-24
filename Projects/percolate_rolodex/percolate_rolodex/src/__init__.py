if __name__ == '__main__':
    import normalizer
    import logging
    logging.basicConfig(filename='..\log\\normalizer.log', level=logging.INFO, filemode='w')
    normalizer.main()
